def get_prime_numbers(number: int) -> list:
    primes = []
    rest = number
    if rest < 2:
        return [-1]
    current_multiplier = 2
    while rest >= 2:
        while rest % current_multiplier == 0:
            primes.append(current_multiplier)
            rest = rest / current_multiplier
        current_multiplier += 1
    return primes
