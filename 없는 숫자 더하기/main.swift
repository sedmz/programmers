import Foundation

func solution(_ numbers:[Int]) -> Int {
    var sum = 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9
    for number in numbers {
        sum -= number
    }
    
    return sum
}
