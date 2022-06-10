import Foundation

func solution(_ s:String) -> Int {
    let stirngs = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    
    var converted = s

    for (number, string) in stirngs.enumerated() {
        converted = converted.replacingOccurrences(of: string, with: String(number))
    }
    
    return Int(converted)!
}

