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
    case that: Vec[T] => this.elems == that.elems
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
   * @param that other vector
   * @return
   */
  def +(that: Vec[T])(implicit n: Numeric[T]): Vec[T] = {
    new Vec(
      pairwise(this, that, (x, y) => n.plus(x, y))
    )
  }

  /**
   * Subtracts a vector from this one.
   * @param that other vector
   * @return
   */
  def -(that: Vec[T])(implicit n: Numeric[T]): Vec[T] = {
    new Vec(
      pairwise(this, that, (x, y) => n.minus(x, y))
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
   * Computes the dot product with another vector.
   * @param that other vector
   * @return
   */
  def dotProd(that: Vec[T])(implicit n: Numeric[T]): T = {
    val seq =
      for ((x, y) <- elems zip that.elems)
      yield n.times(x, y)
    seq.sum
  }

  /**
   * Combines two vectors using a pairwise operation.
   * @param p first vector
   * @param q second vector
   * @param f function to combine pairwise elements
   * @return the sequence of combined pairwise elements
   */
  private def pairwise(p: Vec[T],
                       q: Vec[T],
                       f: (T, T) => T): Seq[T] = {
    for ((x, y) <- p.elems zip q.elems)
    yield f(x, y)
  }
}
