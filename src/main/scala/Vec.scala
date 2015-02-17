/**
 * An n-dimensional vector.
 */
class Vec[T](val elems: Seq[T]) {

  /**
   * Two vectors are equal, if their elements are pairwise equal.
   * @param o object to compare
   * @return
   */
  override def equals(o: Any) = o match {
    case v: Vec[T] => this.elems == v.elems
    case _ => false
  }

  /**
   * Computes the hash code of the underlying sequence of elements.
   * @return
   */
  override def hashCode = elems.hashCode()

  /**
   * Computes the length, or magnitude, of this vector.
   * @return
   */
  def length(implicit n: Numeric[T]): Double = {
    import n._
    math.sqrt(
      elems
        .map(x => x * x)
        .sum
        .toDouble())
  }

  /**
   * Adds this vector to another vector.
   * @param v the other vector
   * @return
   */
  def +(v: Vec[T])(implicit n: Numeric[T]): Vec[T] = {
    new Vec(
      pairwise(v, (x, y) => n.plus(x, y))
    )
  }

  /**
   * Subtracts a vector from this one.
   * @param v the other vector
   * @return
   */
  def -(v: Vec[T])(implicit n: Numeric[T]): Vec[T] = {
    new Vec(
      pairwise(v, (x, y) => n.minus(x, y))
    )
  }

  /**
   * Multiplies this vector by a scalar.
   * @param c the scalar
   * @return
   */
  def *(c: T)(implicit n: Numeric[T]): Vec[T] = {
    new Vec(
      elems.map(n.times(c, _))
    )
  }

  /**
   * Computes the dot product of this vector with another vector.
   * @param v the other vector
   * @return
   */
  def dotProd(v: Vec[T])(implicit n: Numeric[T]): T = {
    pairwise(v, (x, y) => n.times(x, y))
      .sum
  }

  /**
   * Combines this vector with another one using a pairwise operation.
   * @param v the other vector
   * @param f function to combine pairwise elements
   * @return the sequence of combined pairwise elements
   */
  private def pairwise(v: Vec[T],
                       f: (T, T) => T): Seq[T] = {
    for ((x, y) <- this.elems zip v.elems)
    yield f(x, y)
  }
}
