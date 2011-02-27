package AM;

import State.*;
import PrettyPrinter.*;

/**
 * Replace the top two booleans on the stack with their conjunction 
 */
public class And extends Inst {
  /**
   * Constructor
   */
  public And() {
  }

  /**
   * Execute the instruction (operational semantics)
   *
   * @param c Instructions to execute after this one
   * @param state Current state (updated in-place)
   * @param stack Current evaluation stack (updated in-place)
   * @return Remaining instructions to execute
   */
  public Code reduce(Code c, Stack stack, State state) {
    stack.push(stack.popBool() && stack.popBool());
    return c;
  }
  
  /**
   * Pretty-printing
   */
  public void pretty(PrettyPrinter pp) {
    pp.print("AND");
  }

  /**
   * Unparsing
   */
  public String toString() {
    return PrettyPrinter.render(this);
  }
}
