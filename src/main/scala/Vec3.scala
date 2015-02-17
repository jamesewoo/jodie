/**
 * A three-dimensional vector.
 */
class Vec3(val x: Double, val y: Double, val z: Double) extends Vec(Seq(x, y, z)) {

  /**
   * Computes the cross product with another vector.
   * @param that other vector
   * @return
   */
  def crossProd(that: Vec3) = {
    new Vec3(
      y * that.z - z * that.y,
      z * that.x - x * that.z,
      x * that.y - y * that.x)
  }
}
