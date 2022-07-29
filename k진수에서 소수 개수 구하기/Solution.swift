import Foundation

func solution(_ n:Int, _ k:Int) -> Int {
    let numbers: [String] = String(n, radix: k).components(separatedBy: "0")
    return numbers.filter { isPrime(Int($0)) }.count
}

func isPrime(_ n: Int?) -> Bool {
    guard let n = n else { return false }
    guard n >= 2 else { return false }
    guard n >= 4 else { return true }
    return (2...Int(sqrt(Double(n)))).contains { n % $0 == 0 } == false
}
