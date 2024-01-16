package br.com.johnmota.classes;

public class Greeting {
  
  private final String content;
  private final long id;
  
  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }
}
