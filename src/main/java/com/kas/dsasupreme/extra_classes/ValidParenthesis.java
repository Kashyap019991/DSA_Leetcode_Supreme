package com.kas.dsasupreme.extra_classes;

/*import java.util.Stack;

public class ValidParenthesis {
	public static void main(String[] args) {
		Stack<Character> si = new Stack();
		si.push(1);
		si.push(2);
		System.out.println(si.peek());
		System.out.println(si.pop());
		System.out.println(si.peek());
		
		String s = "{([])}";
		
		for(int i = 0; i<s.length();i++){
			char c =s.charAt(i);
			char co;
			if(c == '(' || c == '[' || c == '{')
			{
				si.push(c);
			}
			else{
				switch(c){
				case(')'):
				{
					co = si.peek();
					if(co == '(')
					{
						si.pop();
					}
					else
					{
						System.out.println("not valid parnthesis");
						return;
					}
					break;
				}
				case(']'):
				{
					co = si.peek();
					if(co == '[')
					{
						si.pop();
					}
					else
					{
						System.out.println("not valid parnthesis");
						return;
					}
					break;
				}
				case('}'):
				{
					co = si.peek();
					if(co == '{')
					{
						si.pop();
					}
					else
					{
						System.out.println("not valid parnthesis");
						return;
					}
					break;
				}

				}
								
			}
			
		}
		System.out.println("valid parenthesis");
	}
		ValidParenthesis v = new ValidParenthesis();
		boolean b = v.isValid("(");
		System.out.println(b);
}

    public boolean isValid(String s) {
    	Stack<Character> ci = new Stack(); 
        for(int i=0; i<s.length();i++)
        {
            
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
            	ci.push(c);
            else
            {
            	if(!ci.empty()){
                if(c == ')')
                {
                    if(ci.peek() == '(')
                        ci.pop();
                    else
                        return false;
                }
                else if(c == '}')
                {
                    if(ci.peek() == '{')
                        ci.pop();
                    else
                        return false;
                }
                else	
                {
                    if(ci.peek() == '[')
                        ci.pop();
                    else
                        return false;
                }
            	}
            	else{return false;}
            
            
            }        
        }
        if(ci.empty())
        	return true;
        else
        	return false;
    }
}*/
interface I1 {
  abstract void method(int i);
}
 
interface I2 {
  abstract void method();
}
 
public class ValidParenthesis implements I1, I2 {
 
  @Override
  public void method() {
    System.out.println("hello world");
  }
 
  public static void main(String[] a) {
	  ValidParenthesis mi = new ValidParenthesis();
    I1 i1 = new ValidParenthesis();
    I2 i2 = new ValidParenthesis();
    i1.method(2);
    i2.method();
  }

@Override
public void method(int i) {
	// TODO Auto-generated method stub
	
}

 
}