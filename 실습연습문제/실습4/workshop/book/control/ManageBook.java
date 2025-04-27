package workshop.book.control;

import workshop.book.entity.*;

public class ManageBook {
	public static void main(String[] args) {
        Publication[] publications = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i+1) + ". " + publications[i].toString() + ", " + publications[i].getPage() + "��" + ", " + publications[i].getPrice() + "��" + ", ������:" + publications[i].getPublishDate());
        }

        System.out.println("\n==== ���� ���� ====");
        Publication target = publications[6];
        System.out.println(target.getTitle() + " ���� �� ����: " + target.getPrice() + "��");
        int oldPrice = target.getPrice();
        modifyPrice(target);
        int newPrice = target.getPrice();
        System.out.println(target.getTitle() + " ���� �� ����: " + newPrice + "��");
        System.out.println("����: " + (oldPrice - newPrice) + "��\n");
        
        System.out.println("===== ���ǹ� ��� �м� =====");
        StatisticsAnalyzer sa = new StatisticsAnalyzer();
        sa.printStatistics(publications);
        System.out.println("=============================");
    }

    public static void modifyPrice(Publication pub) {
        if (pub instanceof Magazine) {
            pub.setPrice((int)(pub.getPrice() * 0.6));
        } else if (pub instanceof Novel) {
            pub.setPrice((int)(pub.getPrice() * 0.8));
        } else if (pub instanceof ReferenceBook) {
            pub.setPrice((int)(pub.getPrice() * 0.9));
        }
    }
}
