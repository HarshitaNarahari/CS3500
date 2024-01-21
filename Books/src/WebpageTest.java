
import org.junit.Test;
import static org.junit.Assert.*;

public class WebpageTest {
  Publication chatgpt =
          new Webpage("Chat GPT: Horror for tech geeks",
                  "https://www.pcguide.com/apps/chat-gpt-is-scary/",  1950);

  @Test
  public void testCiteApa() {
    assertEquals(chatgpt.citeApa(), "Chat GPT: Horror for tech geeks. " +
            "Retrieved 1950, from https://www.pcguide.com/apps/chat-gpt-is-scary/.");
  }

  @Test
  public void testCiteMla() {
    assertEquals(chatgpt.citeMla(), "\"Chat GPT: Horror for tech geeks.\" Web. 1950 <https://www.pcguide.com/apps/chat-gpt-is-scary/>." );
  }

}
