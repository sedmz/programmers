import Foundation

func solution(_ price:Int, _ money:Int, _ count:Int) -> Int64 {
    let totalPrice = price * count * (1 + count) / 2
    return max(Int64(totalPrice - money), 0)
}
