package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

// 출판물 배열 통계 분석 클래스
public class StatisticsAnalyzer {

    // 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else {
            return "기타";
        }
    }

    // 1. 타입별 평균 가격 계산 메서드
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgPriceMap = new LinkedHashMap<>();
        String[] types = {"소설", "참고서", "잡지"};
        for (String type : types) {
            if (countMap.containsKey(type)) {
                avgPriceMap.put(type, (double) totalPriceMap.get(type) / countMap.get(type));
            }
        }
        return avgPriceMap;
    }

    // 2. 출판물 유형 분포 계산 메서드
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distMap = new LinkedHashMap<>();
        String[] types = {"소설", "참고서", "잡지"};
        for (String type : types) {
            if (countMap.containsKey(type)) {
                double ratio = ((double) countMap.get(type) / publications.length) * 100.0;
                distMap.put(type, ratio);
            }
        }
        return distMap;
    }

    // 3. 특정 연도 출판물 비율 계산 메서드
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return ((double) count / publications.length) * 100.0;
    }

    // 4. 통계 정보 종합 출력 메서드
    public void printStatistics(Publication[] publications) {
        DecimalFormat dfPrice = new DecimalFormat("#,###");
        DecimalFormat dfRatio = new DecimalFormat("0.00");

        System.out.println("\n===== 출판물 통계 분석 =====");
        
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + dfPrice.format(Math.round(entry.getValue())) + "원");
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + dfRatio.format(entry.getValue()) + "%");
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + dfRatio.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}	