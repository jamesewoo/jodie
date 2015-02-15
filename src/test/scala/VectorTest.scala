import org.scalatest.{FlatSpec, Matchers}

/**
 * Tests the n-dimensional vector.
 */
class VectorTest extends FlatSpec with Matchers {

  "A Vec" should "implement pairwise addition" in {
    val p = new Vec(List(1, 2, 3))
    val q = new Vec(List(2, 3, 4))
    p + q should be(new Vec(List(3, 5, 7)))
  }

  it should "implement pairwise subtraction" in {
    val p = new Vec(List(1, 2, 3))
    val q = new Vec(List(2, 3, 4))
    p - q should be(new Vec(List(-1, -1, -1)))
  }

  it should "implement scalar multiplication" in {
    val p = new Vec(List(1, 2, 3))
    val c = 2
    p * c should be(new Vec(List(2, 4, 6)))
  }

  it should "implement the dot product" in {
    val p = new Vec(List(1, 2, 3))
    val q = new Vec(List(2, 3, 4))
    p dotProd q should be(20)
  }

  it should "have the correct length" in {
    val p = new Vec(List(1, 2, 3))
    p length() should be(Math.sqrt(14))
  }
}
