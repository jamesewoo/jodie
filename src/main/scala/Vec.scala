/**
 * An n-dimensional vector.
 */
class Vec(val elems: List[Double]) {

  /**
   * Two vectors are equal, if their elements are pairwise equal.
   * @param o object to compare
   * @return
   */
  override def equals(o: Any) = o match {
    case that: Vec => this.elems == that.elems
    case _ => false
  }

  /**
   * Computes the hash code of the underlying list of elements.
   * @return
   */
  override def hashCode = elems.hashCode()

  /**
   * Computes the length, or magnitude, of this vector.
   * @return
   */
  def length(): Double = {
    Math.sqrt(elems.map(x => x * x).sum)
  }

  /**
   * Adds this vector to another vector.
   * @param that other vector
   * @return
   */
  def +(that: Vec): Vec = {
    new Vec(
      pairwise(this, that, (x, y) => x + y)
    )
  }

  /**
   * Subtracts a vector from this one.
   * @param that other vector
   * @return
   */
  def -(that: Vec): Vec = {
    new Vec(
      pairwise(this, that, (x, y) => x - y)
    )
  }

  /**
   * Multiplies this vector by a scalar.
   * @param c the scalar
   * @return
   */
  def *(c: Double): Vec = {
    new Vec(
      elems.map(c * _)
    )
  }

  /**
   * Computes the dot product with another vector.
   * @param that other vector
   * @return
   */
  def dotProd(that: Vec): Double = {
    val list =
      for ((x, y) <- elems zip that.elems)
      yield x * y
    list.sum
  }

  /**
   * Combines two vectors using a pairwise operation.
   * @param p first vector
   * @param q second vector
   * @param f function to combine pairwise elements
   * @return the list of pairwise elements
   */
  private def pairwise(p: Vec,
                       q: Vec,
                       f: (Double, Double) => Double): List[Double] = {
    for ((x, y) <- p.elems zip q.elems)
    yield f(x, y)
  }
}
