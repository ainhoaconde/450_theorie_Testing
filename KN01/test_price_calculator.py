import math

def calculate_price(baseprice, specialprice, extraprice, extras, discount):
    addon_discount = 0.0
    
    if extras >= 3:
        addon_discount = 10
    elif extras >= 5:
        addon_discount = 15
    
    addon_discount = max(addon_discount, discount)
    
    result = (baseprice / 100 * (100 - discount)) + specialprice + (extraprice / 100 * (100 - addon_discount))
    
    return result

def test_calculate_price():
    test_ok = True

    baseprice = 1000.0
    specialprice = 200.0
    extraprice = 50.0
    extras = 4
    discount = 12.0

    # Expected result: (1000 / 100 * (100 - 12)) + 200 + (50 / 100 * (100 - 10))
    expected_result = (baseprice / 100 * (100 - discount)) + specialprice + (extraprice / 100 * (100 - 10))
    
    calculated_result = calculate_price(baseprice, specialprice, extraprice, extras, discount)

    # Check if the calculated result is close to the expected result with a small tolerance
    tolerance = 0.0001
    if abs(calculated_result - expected_result) > tolerance:
        print("Test failed: Calculated result doesn't match the expected result.")
        test_ok = False
    else:
        print("Test passed: Calculated result matches the expected result.")

    return test_ok

if __name__ == "__main__":
    test_result = test_calculate_price()
    if test_result:
        print("All tests passed.")
    else:
        print("Some tests failed.")
