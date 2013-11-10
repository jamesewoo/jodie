import math

def add(p, q):
    """Adds vectors  p and q."""
    return [x + y for (x, y) in list(zip(p, q))]

def crossProduct(p, q):
    """Cross product of p and q."""
    if len(p) == 3 and len(q) == 3:
        return [p[1]*q[2] - p[2]*q[1], p[2]*q[0] - p[0]*q[2], p[0]*q[1] - p[1]*q[0]]
    else:
        print("p and q must be of length 3")

def dotProduct(p, q):
    """Dot product of p and q."""
    return sum([x * y for (x, y) in list(zip(p, q))])

def scalarMultiply(a, v):
    """Scalar multiplication of a and v."""
    return [a * x for x in v]

def subtract(p, q):
    """Computes p - q."""
    return [x - y for (x, y) in list(zip(p, q))]

def norm(v):
    """Norm, or magnitude, of v."""
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
