import java.io.IOException;

public void whenWriteStringUsingBufferedWritter_thenCorrect() 
  throws IOException {
    String str = "Hello";
    BufferedWriter writer = new BufferedWriter(new FileWriter(test.txt));
    writer.write("Hello Hello");
    
    writer.close();
}