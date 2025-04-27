package workshop.book.control;

import workshop.book.entity.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		Map<String, Integer> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Publication p : publications) {
            String type = getPublicationType(p);
            totalPrices.put(type, totalPrices.getOrDefault(type, 0) + p.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        // �� �κ��� GPT ���
        Map<String, Double> averages = new HashMap<>();
        for (String type : totalPrices.keySet()) {
            averages.put(type, totalPrices.get(type) / (double) counts.get(type));
        }
        
        return averages;
	}
	
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		Map<String, Integer> counts = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : counts.keySet()) {
            distribution.put(type, (counts.get(type) / (double) publications.length) * 100);
        }
        
        return distribution;
	}
	
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        
        return (count / (double) publications.length) * 100;
    }
	
	private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        else if (pub instanceof Magazine) return "����";
        else if (pub instanceof ReferenceBook) return "����";
        else return "��Ÿ";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        for (String type : avgPrice.keySet()) {
            System.out.println("  - " + type + ": " + df.format(avgPrice.get(type)) + "��");
        }

        System.out.println("\n2. ���ǹ� ���� ����:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.println("  - " + type + ": " + String.format("%.2f", distribution.get(type)) + "%");
        }

        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: " +
            String.format("%.2f", calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}
