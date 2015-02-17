import org.scalatest.{Matchers, FlatSpec}

/**
 * Tests the three-dimensional vector.
 */
class Vec3Test extends FlatSpec with Matchers {

  "A Vec3" should "implement pairwise addition" in {
    val p = new Vec3(1, 2, 3)
    val q = new Vec3(2, 3, 4)
    p + q should be(new Vec3(3, 5, 7))
  }

  it should "implement pairwise subtraction" in {
    val p = new Vec3(1, 2, 3)
    val q = new Vec3(2, 3, 4)
    p - q should be(new Vec3(-1, -1, -1))
  }

  it should "implement scalar multiplication" in {
    val p = new Vec3(1, 2, 3)
    val c = 2
    p * c should be(new Vec3(2, 4, 6))
  }

  it should "implement the dot product" in {
    val p = new Vec3(1, 2, 3)
    val q = new Vec3(2, 3, 4)
    p dotProd q should be(20)
  }

  it should "implement the cross product" in {
    val p = new Vec3(1, 2, 3)
    val q = new Vec3(2, 3, 4)
    p crossProd q should be(new Vec3(-1, 2, -1))
  }

  it should "have the correct length" in {
    val p = new Vec3(1, 2, 3)
    p.length should be(Math.sqrt(14))
  }
}
