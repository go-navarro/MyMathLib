# MyMathLib

# Vector operations

## Dot product

```Vector u = new Vector(1, 2, 3);```

```Vector v = new Vector(4, 5, 6);```

```Vector.dot(u,v);```

$$
\langle u, v \rangle = \sum_{k \in 1:3} u_{k}v_{k}
$$

## Cumulative sum

```Vector v = new Vector(1, 2, 3);```

```Cumulative.sum(v);```

$$
v_{k} = \sum_{\ell \in 1:k} v_{\ell}
$$

## Cumulative product


```Vector v = new Vector(1, 2, 3);```

```Cumulative.product(v);```


$$
v = \left(v_{1}, \dots, v_{n}\right)
$$

$$
v_{k} = \prod_{\ell \in 1:k} v_{\ell}
$$

## Slice


```Vector v = new Vector(1, 2, 3, 4);```

```v.slice(1, 3);```

```v.slice(2);```

$$
v_{1:3} = \left(v_{1}, v_{2}, v_{3}\right)
$$

$$
v_{:2} = \left(v_{1}, v_{2}\right)
$$

## Apply function to elements

```Vector v = new Vector(1, 2, 3, 4);```

```v.apply(x -> f(x));```

$$
f:\mathbb{R} \rightarrow \mathbb{R}
$$

$$
\vec{f}:\mathbb{R}^{n} \rightarrow \mathbb{R}^{n}
$$

$$
\vec{f}(v) = \left(
f(v_{1}) \dots, f(v_{n})
\right)
$$

