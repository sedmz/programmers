func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    var reporters: [String: [String]] = [:]
    var reporteds: [String: Int] = [:]
    for _report in report {
        let splited = _report.components(separatedBy: " ")
        var _reporteds = reporters[splited[0]] ?? []
        if !_reporteds.contains(splited[1]) {
            _reporteds.append(splited[1])
            let a = reporteds[splited[1]] ?? 0
            reporteds[splited[1]] = a + 1
        }
        reporters[splited[0]] = _reporteds
    }
    
    for reported in reporteds {
        if reported.value < k {
            reporteds.removeValue(forKey: reported.key)
        }
    }
    
    var answer: [Int] = []
    for id in id_list {
        var cnt = 0
        let reported = reporters[id] ?? []
        for _reported in reported {
            if reporteds.keys.contains(_reported) {
                cnt += 1
            }
        }
        answer.append(cnt)
    }
    
    return answer
}
