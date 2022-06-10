import Foundation

func solution(_ sizes:[[Int]]) -> Int {
    var maxWidth = 0
    var maxHeight = 0
    
    for size in sizes {
        let sorted = size.sorted()
        maxWidth = max(maxWidth, sorted[0])
        maxHeight = max(maxHeight, sorted[1])
    }
    
    return maxWidth * maxHeight
}
