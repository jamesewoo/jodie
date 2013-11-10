import math

def add(p, q):
    """Vector sum of p and q."""
    return [x + y for (x, y) in list(zip(p, q))]

def dotProduct(p, q):
    """Dot product of p and q."""
    return sum([x * y for (x, y) in list(zip(p, q))])

def scalarProduct(a, v):
    """Scalar product of a and v."""
    return [a * x for x in v]

def subtract(p, q):
    """Returns p - q."""
    return [x - y for (x, y) in list(zip(p, q))]

def norm(v):
    """Norm of v."""
    return math.sqrt(normSquared(v))

def normSquared(v):
    """Norm squared of v."""
    return sum([x**2 for x in v])

def planarAngle(p, q):
    """Planar angle between p and q in radians."""
    return math.acos(dotProduct(p, q) / (norm(p) * norm(q)))

def perp(p, q):
    """Perpendicular component of p with respect to q."""
    return subtract(p, project(p, q))

def project(p, q):
    """Projection of p onto q."""
    return scalarProduct(dotProduct(p, q) / normSquared(q), q)

def unit(v):
    """Unit vector of v."""
    return scalarProduct(1 / norm(v), v)
