import Foundation

func solution(_ n:Int) -> Int {
    return (1..<n).first { n % $0 == 1 }!
}
