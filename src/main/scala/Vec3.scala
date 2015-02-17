/**
 * A three-dimensional vector.
 */
class Vec3[T](val x: T, val y: T, val z: T) extends Vec(Seq(x, y, z)) {

  /**
   * Computes the cross product of this vector with another vector.
   * @param v the other vector
   * @return
   */
  def crossProd(v: Vec3[T])(implicit n: Numeric[T]) = {
    import n._
    new Vec3(
      y * v.z - z * v.y,
      z * v.x - x * v.z,
      x * v.y - y * v.x)
  }
}
