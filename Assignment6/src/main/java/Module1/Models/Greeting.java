package Module1.Models;

public class Greeting {
    private String greeting;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting() {
    }

    public Greeting(String greeting) {
        this.greeting = greeting;
    }
    public void sayHello(){
        System.out.println(greeting);
    }

}
