package While.Bexp;

import State.*;
import AM.*;
import PrettyPrinter.*;

/**
 * Logical "and" of two boolean expressions 
 */
public class And extends Bexp {
  /**
   * Left operand
   */
  private Bexp b1;
  
  /**
   * Right operand
   */
  private Bexp b2;

  /**
   * Constructor
   *
   * @param b1 Left operand
   * @param b2 Right operand
   */
  public And(Bexp b1, Bexp b2) {
    this.b1 = b1;
    this.b2 = b2;
  }

  /**
   * Big-step semantics 
   *
   * @return Value of the expression
   */
  public boolean eval(Memory memory) {
    return b1.eval(memory) && b2.eval(memory); 
  }

  /**
   * Is this expression a value?
   *
   * @return False
   */
  public boolean isValue() {
    return false;
  }

  /**
   * Small-step semantics
   *
   * @return The expression after taking a single reduction step
   */
  public Bexp reduce(Memory memory) {
    if(!b1.isValue())
      return new And(b1.reduce(memory), b2);
    else if(!b2.isValue())
      return new And(b1, b2.reduce(memory));
    else 
      return new ConstantBool(b1.value() && b2.value());  
  }

  /**
   * Compilation
   *
   * @return List of abstract machine (AM) instructions
   */
  public Code compile() {
    return b2.compile().append(b1.compile()).append(new AM.And());
  }

  /**
   * Pretty-printing
   */
  public void pretty(PrettyPrinter pp) {
    pp.binOp(b1, "&&", b2);
  }

  /**
   * Unparsing
   */
  public String toString() {
    return PrettyPrinter.render(this);
  }
}
