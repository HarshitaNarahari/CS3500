;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname lecture01) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;; A Publication is one of:
;; -- (make-book String String String String Number)
;; -- (make-article String String String Number Number Number)
(define-struct book [title author publisher location year])
(define-struct article [title author journal volume issue year])

;; Examples:
(define rushdie
        (make-book "Midnight's Children" "Salman Rushdie"
                   "Jonathan Cape" "London" 1980))
(define turing
        (make-article "Computing machinery and intelligence"
                      "A. M. Turing" "Mind" 59 236 1950))

#|
;; process-publication: Publication -> ...
;; Template for processing Publications
(define (process-publication: pub)
  (cond
    [(book? pub)
     (... (book-title pub) ... (book-author pub) ... (book-publisher pub) ...
          (book-location pub) ... (book-year pub) ...)]
    [(article? pub)
     (... (article-title pub) ... (article-author pub) ...
          (article-journal pub) ... (article-volume pub) ...
          (article-issue pub) ... (article-year pub) ...)]))
|#

;; cite-apa: Publication -> String
;; To format a publication for citation in APA style.
(define (cite-apa pub)
  (cond
    [(book? pub)
     (format "~a (~a). ~a. ~a: ~a."
             (book-author pub) (book-year pub) (book-title pub)
             (book-location pub) (book-publisher pub))]
    [(article? pub)
     (format "~a (~a). ~a. ~a, ~a(~a)."
             (article-author pub) (article-year pub) (article-title pub)
             (article-journal pub) (article-volume pub) (article-issue pub))]
    #;[(webpage? pub)
     (format "~a. Retrieved ~a, from ~a."
             (webpage-title pub) (webpage-retrieved pub) (webpage-url pub))]))

;; cite-mla: Publication -> String
;; To format a publication for citation in MLA style.
(define (cite-mla pub)
  (cond
    [(book? pub)
     (format "~a. ~a. ~a: ~a, ~a."
             (book-author pub) (book-title pub) (book-location pub)
             (book-publisher pub) (book-year pub))]
    [(article? pub)
     (format "~a. \"~a.\" ~a ~a.~a (~a)."
             (article-author pub) (article-title pub) (article-journal pub)
             (article-volume pub) (article-issue pub) (article-year pub))]
    #;[(webpage? pub)
     (format "\"~a.\" Web. ~a <~a>."
             (webpage-title pub) (webpage-retrieved pub) (webpage-url pub))]))

(check-expect
 (cite-apa rushdie)
 "Salman Rushdie (1980). Midnight's Children. London: Jonathan Cape.")
(check-expect
 (cite-mla rushdie)
 "Salman Rushdie. Midnight's Children. London: Jonathan Cape, 1980.")
(check-expect
 (cite-apa turing)
 "A. M. Turing (1950). Computing machinery and intelligence. Mind, 59(236).")
(check-expect
 (cite-mla turing)
 "A. M. Turing. \"Computing machinery and intelligence.\" Mind 59.236 (1950).")

#|
;; A Publication is one of:
;; -- (make-book String String String String Number)
;; -- (make-article String String String Number Number Number)
;; -- (make-webpage String String String)
;; (define-struct book [title author publisher location year])
;; (define-struct article [title author journal volume issue year])
(define-struct webpage [title url retrieved])

;; Examples:
(define cs3500
  (make-webpage "CS3500: Object-Oriented Design"
                "http://www.ccs.neu.edu/home//cs3500/"
                "August 11, 2014"))

(check-expect
 (cite-apa cs3500)
 (string-append "CS3500: Object-Oriented Design. Retrieved August 11, 2014, "
                "from http://www.ccs.neu.edu/course/cs3500/."))
(check-expect
 (cite-mla cs3500)
 (string-append "\"CS3500: Object-Oriented Design.\" Web. August 11, 2014 "
                "<http://www.ccs.neu.edu/course/cs3500/>."))
|#

;; A Publication is CitationStyle -> String
;;   where
;; CitationStyle is one of:
;; -- "apa"
;; -- "mla"

#|
;; create-publication: ... -> [CitationStyle -> String]
;; Template for constructing publications
(define (create-publication args ...)
  (lambda (style)
    (cond
      [(string=? style "apa") (... args ...)]
      [(string=? style "mla") (... args ...)])))
|#

;; new-book: String String String String Number -> Publication
;; To construct a new book.
(define (new-book title author publisher location year)
  (lambda (style)
    (cond
      [(string=? style "apa")
       (format "~a (~a). ~a. ~a: ~a."
               author year title location publisher)]
      [(string=? style "mla")
       (format "~a. ~a. ~a: ~a, ~a."
               author title location publisher year)])))

;; Example:
(define rushdie*
        (new-book "Midnight's Children" "Salman Rushdie"
                  "Jonathan Cape" "London" 1980))

(check-expect
 (rushdie* "apa")
 "Salman Rushdie (1980). Midnight's Children. London: Jonathan Cape.")
(check-expect (rushdie* "apa") (cite-apa rushdie))
(check-expect (rushdie* "mla") (cite-mla rushdie))

;; new-article: String String String Number Number Number -> Publication
;; To construct a new article.
(define (new-article title author journal volume issue year)
  (lambda (style)
    (cond
      [(string=? style "apa")
       (format "~a (~a). ~a. ~a, ~a(~a)."
               author year title journal volume issue)]
      [(string=? style "mla")
       (format "~a. \"~a.\" ~a ~a.~a (~a)."
               author title journal volume issue year)])))

;; Examples:
(define turing*
        (new-article "Computing machinery and intelligence"
                     "A. M. Turing" "Mind" 59 236 1950))

(check-expect (turing* "apa") (cite-apa turing))
(check-expect (turing* "mla") (cite-mla turing))

#|
;; new-webpage: String String String -> Publication
;; To construct a new web page.
(define (new-webpage title url retrieved)
  (lambda (style)
    (cond
      [(string=? style "apa")
       (format "~a. Retrieved ~a, from ~a."
               title retrieved url)]
      [(string=? style "mla")
       (format "\"~a.\" Web. ~a <~a>."
               title retrieved url)])))

;; Examples:
(define cs3500*
        (new-webpage "CS3500: Object-Oriented Design"
                     "http://www.ccs.neu.edu/course/cs3500/"
                     "August 11, 2014"))

(check-expect (cs3500* "apa") (cite-apa cs3500))
(check-expect (cs3500* "mla") (cite-mla cs3500))
|#

(check-expect
 (map (lambda (pub) (pub "mla"))
      (list rushdie* turing* #;cs3500*))
 (map cite-mla
      (list rushdie turing #;cs3500)))
