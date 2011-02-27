package AM;

import State.*;
import PrettyPrinter.*;

/**
 * Replace the top two booleans on the stack with their disjunction 
 */
public class Or extends Inst {
  /**
   * Constructor
   */
  public Or() {
  }

  /**
   * Execute the instruction (operational semantics)
   *
   * @param c Instructions to execute after this one
   * @param memory Current memory (updated in-place)
   * @param stack Current evaluation stack (updated in-place)
   * @return Remaining instructions to execute
   */
  public Code reduce(Code c, Stack stack, Memory memory) {
    stack.push(stack.popBool() || stack.popBool());
    return c;
  }
  
  /**
   * Pretty-printing
   */
  public void pretty(PrettyPrinter pp) {
    pp.print("OR");
  }

  /**
   * Unparsing
   */
  public String toString() {
    return PrettyPrinter.render(this);
  }
}
