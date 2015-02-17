/**
 * A three-dimensional vector.
 */
class Vec3[T](val x: T, val y: T, val z: T) extends Vec(Seq(x, y, z)) {

  /**
   * Computes the cross product with another vector.
   * @param that other vector
   * @return
   */
  def crossProd(that: Vec3[T])(implicit n: Numeric[T]) = {
    import n._
    new Vec3(
      y * that.z - z * that.y,
      z * that.x - x * that.z,
      x * that.y - y * that.x)
  }
}
