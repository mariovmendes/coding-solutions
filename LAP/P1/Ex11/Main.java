// Este e' um tipo-objecto:

interface IntStack {
    int capacity() ;
    int size() ;
    boolean empty() ;
    boolean full() ;
    int top() ;
    void push(int v) ;
    void pushN(int... vs) ;
    void pop() ;
    void popN(int n) ;
}

// Esta e' uma implementacao do tipo-objecto anterior:

class IntStackClass implements IntStack {
    private final static int defaultCapacity = 100 ;
    private int[] elems ;
    private int top ;

    IntStackClass(int capacity) {
        elems = new int[capacity] ;
        top = 0 ;
    }
    IntStackClass() {
        this(defaultCapacity) ;
    }

    public int capacity() {
        return elems.length ;
    }
    public int size() {
        return top ;
    }
    public boolean empty() {
        return size() == 0 ;
    }
    public boolean full() {
        return size() == capacity() ;
    }
    public int top() {
        if( empty() )
            throw new EmptyStackException() ;
        return elems[top-1] ;
    }
    public void push(int v) {
        if( full() )
            throw new StackOverflowError() ;
        elems[top++] = v ;
    }
    public void pushN(int... vs) {
        for(int v : vs)
            push(v) ;
    }
    public void pop() {
        if( empty() )
            throw new EmptyStackException() ;
        top-- ;
    }
    public void popN(int n) {
        for( int i = 0 ; i < n ; i++ )
            pop() ;
    }

  // TESTING
    public static void main(String[] args) {
        System.out.println("Welcome to the IntStackClass class!!") ;
        IntStack s = new IntStackClass() ;
        System.out.println(s.capacity()) ;
        try {
            s.pushN(1,2,3,4,5) ;
        }
        catch ( StackOverflowError e ) {
            System.out.println("Stack Overflow!") ;
            System.out.println("Bye bye!") ;
            System.exit(1) ;
        }
        catch ( EmptyStackException  e ) {
            System.out.println("Stack Underflow!") ;
            System.out.println("Bye bye!") ;
            System.exit(1) ;
        }
        s.pushN(1,2,3,4,5) ;
        s.popN(9) ;
        System.out.println(s.top()) ;
    }

}

public enum Exc {
    // Enumeration values
      noneExc, stackOverflowExc, emptyStackExc, stackUnderflowExc ;
    // Current exception
      private static Exc curr = noneExc ;
    // Static methods
      public static Exc Catch() { Exc x = curr ; curr = noneExc ; return x ; }
      public static void Throw(Exc e) { curr = e ; }
      public static boolean Throwed() { return curr != noneExc ; }
      public static void DefaultHandling() {
          switch( curr ) {
              case noneExc :
                  break ;
              case stackOverflowExc:
                  System.err.println("StackOverflow Exception") ;
                  System.exit(0) ;
              case stackUnderflowExc:
                  System.err.println("StackUnderflow Exception") ;
                  System.exit(0) ;
              default:
                  System.err.println("Unknown Exception") ;
                  System.exit(0) ;
          }
      }
}