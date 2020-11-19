package net.kiranatos.stepik.java_adaptive.jetbrains;

/*
You are asked to help with Java programming in a company that makes boxes. 
Their former Java programmer created Box class that uses objects and 
requires casting. Casting is slow (http://www.javaworld.com/article/2076555/build-ci-sdlc/java-performance-programming--part-2--the-cost-of-casting.html)
and error-prone (which is not good, so they decide to fire him), so could 
you create Box implementation that will not require casting but provide 
type-checking at a compile time?

Sample Input:
Magical Box class

Sample Output:
Well done!
*/

/**
Object-based box class that requires casting every time you want to get some specific stuff from it, e.g.:

    Box cakeBox = new Box();
    cakeBox.put(new Cake());
    // Without casting only object can be retrieved out of the box
    Cake cake = (Cake) cakeBox.get();

Casting is not desirable and can fall at runtime, could you create more... generic solution?
*/
class Box<T> {

    private T item;

    public void put(T item) {
    	this.item = item;
    }

    public T get() {
        return this.item;
    }
}


/*
public static void main(String[] args) {
        Box<Cake> cakeBox = new Box();
        cakeBox.put(new Cake());        
        Cake cake = cakeBox.get();        
    }   
*/