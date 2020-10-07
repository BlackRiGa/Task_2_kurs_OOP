package vsu.cs.tasks;

import java.util.Scanner;

public class TextInterface {
    
    public static void userInteraction(Bathroom test){
        Scanner sc = new Scanner(System.in);
        System.out.println("Нажмите любую клавишу, чтобы продолжить, либо введите 'exit' чтобы выйти. Нажмите Enter, чтобы подтвердить действие.");
        String answer1, answer2;
        answer1 = sc.nextLine();
        try {
            while (!answer1.equals("exit")) {
                System.out.println("Введите номер операции, которую вы хотите провести:\n 1)Добавить \n 2)Удалить \n 3)Найти \n 4)Соединить \n 5)Отсоединить ");
                answer1 = sc.next();
                if(answer1.equals("exit")) continue;
                switch (answer1) {
                    case ("1"):
                        add(sc, test);
                        break;
                    case ("2"):
                        delete(sc, test);
                        break;
                    case ("4"):
                        join(sc, test);
                        break;
                    case ("5"):
                        disconnect(sc, test);
                        break;
//                    case ("6"):
//                        System.out.println("Введите путь для сохранения файла");
//                        answer2 = sc.next();
//                        test.savePlan(answer2);
//                        break;
//                    case ("7"):
//                        System.out.println("Введите путь для загрузки файла");
//                        answer2 = sc.next();
//                        test.loadPlan(answer2);
//                        break;
//                    case ("8"):
//                        Links l = test.See();
//                        List t = test.SeeT();
//                        for(int i=0; i<l.links.size();i++){
//                            System.out.println(l.links.get(i).What+l.links.get(i).WithWhom+l.links.get(i).LinkType);
//                        }
//                        break;
                    default:
                        search(sc, test);
                        break;
                }
                System.out.println("Операция успешно проведена");
            }
        } catch (Exception ex) {
        }
    }
    
    public static void add(Scanner sc, Bathroom test) throws Exception{
        String name, answer3;
        int int1, int2;
        System.out.println("Что вы желаете добавить?\n 1)Трубу \n 2)Фитинг \n 3)Потребитель воды \n 4)Источник воды \n 5)Слив");
        String answer2 = sc.next();
        switch (answer2) {
            case ("1"):
                System.out.println("Введите имя трубы");
                name = sc.next();
                System.out.println("Введите длину трубы");
                int1 = sc.nextInt();
                System.out.println("Введите диаметр трубы");
                int2 = sc.nextInt();
                System.out.println("Введите тип трубы:\n 1)Водопроводная \n 2)Канализационная");
                answer3 = sc.next();
                if (answer3.equals("1")) {
                    test.addTube(name, int1, int2, Type.PLUMBING);
                } else {
                    test.addTube(name, int1, int2, Type.SEWER);
                }
                break;
            case ("2"):
                System.out.println("Введите имя фитинга");
                name = sc.next();
                System.out.println("Введите количество входов фитинга");
                int1 = sc.nextInt();
                System.out.println("Введите количество выходов фитинга");
                int2 = sc.nextInt();
                System.out.println("Введите тип фитинга:\n 1)Водопроводный \n 2)Канализационный");
                answer3 = sc.next();
                if (answer3.equals("1")) {
                    test.addFitting(name, int1, int2, Type.PLUMBING);
                } else {
                    test.addFitting(name, int1, int2, Type.SEWER);
                }
                break;
            case ("3"):
                System.out.println("Введите имя потребителя");
                name = sc.nextLine();
                System.out.println("Введите длину потребителя");
                int1 = sc.nextInt();
                System.out.println("Введите ширину потребителя");
                int2 = sc.nextInt();
                test.addWaterConsumer(name, int1, int2);
                break;
            case ("4"):
                System.out.println("Введите имя источника");
                name = sc.next();
                test.addWaterSource(name);
                break;
            default:
                System.out.println("Введите имя слива");
                name = sc.next();
                test.addDrain(name);
                break;
        }
    }
    
    public static void delete(Scanner sc, Bathroom test) throws Exception{
        String name;
        System.out.println("Что вы желаете удалить?\n 1)Трубу \n 2)Фитинг \n 3)Потребитель воды \n 4)Источник воды \n 5)Слив");
        String answer2 = sc.next();
        switch (answer2) {
            case ("1"):
                System.out.println("Введите имя трубы");
                name = sc.next();
                test.deleteTube(name);
                break;
            case ("2"):
                System.out.println("Введите имя фитинга");
                name = sc.next();
                test.deleteFitting(name);
                break;
            case ("3"):
                System.out.println("Введите имя потребителя");
                name = sc.next();
                test.deleteWaterConsumer(name);
                break;
            case ("4"):
                System.out.println("Введите имя источника");
                name = sc.next();
                test.deleteWaterSource(name);
                break;
            default:
                System.out.println("Введите имя слива");
                name = sc.next();
                test.deleteDrain(name);
                break;
        }
    }
    
    public static void join(Scanner sc, Bathroom test) throws Exception {
        String name, name2, answer3;
        System.out.println("Что вы желаете соединить?\n 1)Трубу \n 2)Фитинг \n 3)Потребитель воды \n 4)Источник воды");
        String answer2 = sc.next();
        switch (answer2) {
            case ("1"): {
                System.out.println("Введите имя трубы");
                name = sc.next();
                System.out.println("Введите имя присоединяемого фитинга");
                name2 = sc.next();
                Tube tube = test.searchTube(name);
                Fitting fitting = test.searchFitting(name2);
                if(fitting.type == Type.SEWER){
                    test.links.connect(tube, fitting, LinkType.OUT_TUBE_IN_FITTING);
                }else{
                    System.out.println("1.1");
                }
                break;
            }
            case ("3"): {
                System.out.println("Введите имя потребителя");
                name = sc.next();
                System.out.println("Введите имя присоединяемого фитинга");
                name2 = sc.next();
                WaterConsumer wconsumer = test.searchWaterConsumer(name);
                Fitting fitting = test.searchFitting(name2);
                if(fitting.type == Type.SEWER){
                    test.links.connect(wconsumer, fitting, LinkType.OUT_WATER_CONSUMER_IN_FITTING);
                }else{
                    System.out.println("1.3");
                }
                break;
            }
            case ("4"): {
                System.out.println("Введите имя источника");
                name = sc.next();
                System.out.println("Введите имя присоединяемого фитинга");
                name2 = sc.next();
                WaterSource wsource = test.searchWaterSource(name);
                Fitting fitting = test.searchFitting(name2);
                if(fitting.type == Type.PLUMBING){
                    test.links.connect(wsource, fitting, LinkType.OUT_WATER_SOURCE_IN_FITTING);
                }else{
                    System.out.println("1.4");
                }
                break;
            }
            default:
                System.out.println("Введите имя фитинга");
                name = sc.next();
                System.out.println("Что вы желаете присоединить?\n 1)Трубу \n 2)Потребитель воды \n 3)Слив");
                answer3 = sc.next();
                switch (answer3) {
                    case ("1"): {
                        System.out.println("Введите имя трубы");
                        name2 = sc.next();
                        Fitting fitting = test.searchFitting(name);
                        Tube tube = test.searchTube(name2);
                        if(fitting.type == tube.type){
                            test.links.connect(fitting, tube, LinkType.OUT_FITTING_IN_TUBE);
                        }else{
                            System.out.println("1.2.1");
                        }
                        break;
                    }
                    case ("2"): {
                        System.out.println("Введите имя потребителя");
                        name2 = sc.next();
                        Fitting fitting = test.searchFitting(name);
                        WaterConsumer wconsumer = test.searchWaterConsumer(name2);
                        if(fitting.type == Type.PLUMBING){
                            test.links.connect(fitting, wconsumer, LinkType.OUT_FITTING_IN_WATER_CONSUMER);
                        }else{
                            System.out.println("1.2.2");
                        }
                        break;
                    }
                    default:{
                        System.out.println("Введите имя слива");
                        name2 = sc.next();
                        Fitting fitting = test.searchFitting(name);
                        Drain drain = test.searchDrain(name2);
                        if(fitting.type == Type.SEWER){
                            test.links.connect(fitting, drain, LinkType.OUT_FITTING_IN_DRAIN);
                        }else{
                            System.out.println("1.2.3");
                        }
                        break;
                    }
                }
                break;
        }
    }
    
    public static void disconnect(Scanner sc, Bathroom test) throws Exception {
        String name, name2, answer3;
        Fitting fitting;
        System.out.println("Что вы желаете отсоединить?\n 1)Трубу \n 2)Фитинг \n 3)Потребитель воды \n 4)Источник воды \n 5)Слив");
        String answer2 = sc.next();
        switch (answer2) {
            case ("1"):
                System.out.println("Введите имя трубы");
                name = sc.next();
                System.out.println("Введите имя фитинга");
                name2 = sc.next();
                Tube tube = test.searchTube(name);
                fitting = test.searchFitting(name2);
                test.links.disconnect(tube, fitting, LinkType.OUT_TUBE_IN_FITTING);
                break;
            case ("2"):
                System.out.println("Введите имя фитинга");
                name = sc.next();
                fitting = test.searchFitting(name);
                System.out.println("Что вы желаете отсоединить?\n 1)Трубу \n 2)Потребитель воды \n 3)Источник воды \n 4)Слив");
                answer3 = sc.next();
                switch (answer3) {
                    case ("1"):
                        System.out.println("Введите имя трубы");
                        name2 = sc.next();
                        test.links.disconnect(fitting, test.searchTube(name2), LinkType.OUT_FITTING_IN_TUBE);
                        break;
                    case ("2"):
                        System.out.println("Потребителя воды");
                        name2 = sc.next();
                        test.links.disconnect(fitting, test.searchWaterConsumer(name2), LinkType.OUT_FITTING_IN_WATER_CONSUMER);
                        break;
                    case ("3"):
                        System.out.println("Источника воды");
                        name2 = sc.next();
                        test.links.disconnect(test.searchWaterSource(name2), fitting, LinkType.OUT_WATER_SOURCE_IN_FITTING);
                        break;
                    default:
                        System.out.println("Введите имя слива");
                        name2 = sc.next();
                        test.links.disconnect(fitting, test.searchDrain(name2), LinkType.OUT_FITTING_IN_DRAIN);
                        break;
                }
                break;
            case ("3"):
                System.out.println("Введите имя потребителя");
                name = sc.next();
                System.out.println("Введите имя фитинга");
                name2 = sc.next();
                fitting = test.searchFitting(name2);
                WaterConsumer wconsumer = test.searchWaterConsumer(name);
                test.links.disconnect(fitting, wconsumer, LinkType.OUT_FITTING_IN_WATER_CONSUMER);
                test.links.connect(wconsumer, fitting, LinkType.OUT_WATER_CONSUMER_IN_FITTING);
                break;
            case ("4"):
                System.out.println("Введите имя источника");
                name = sc.next();
                System.out.println("Введите имя фитинга");
                name2 = sc.next();
                test.links.disconnect(test.searchWaterSource(name), test.searchFitting(name2), LinkType.OUT_WATER_SOURCE_IN_FITTING);
                break;
            default:
                System.out.println("Введите имя слива");
                name = sc.next();
                System.out.println("Введите имя фитинга");
                name2 = sc.next();
                test.links.disconnect(test.searchFitting(name2), test.searchDrain(name), LinkType.OUT_FITTING_IN_DRAIN);
                break;
        }
    }
    
    public static void search(Scanner sc, Bathroom test) throws Exception {
        String name;
        System.out.println("Что вы желаете найти?\n 1)Трубу \n 2)Фитинг \n 3)Потребитель воды \n 4)Источник воды \n 5)Слив");
        String answer2 = sc.next();
        switch (answer2) {
            case ("1"):
                System.out.println("Введите имя трубы");
                name = sc.next();
                Tube desiredT = test.searchTube(name);
                System.out.println(" Длина: " + desiredT.length + "\n Ширина: " + desiredT.diameter + "\n Тип: " + desiredT.type);
                break;
            case ("2"):
                System.out.println("Введите имя фитинга");
                name = sc.next();
                Fitting desiredF = test.searchFitting(name);
                System.out.println("Тип: " + desiredF.type);
                break;
            case ("3"):
                System.out.println("Введите имя потребителя");
                name = sc.next();
                WaterConsumer desiredW = test.searchWaterConsumer(name);
                System.out.println(" Длина: " + desiredW.length + "\n Ширина: " + desiredW.width);
                break;
            case ("4"):
                System.out.println("Введите имя источника");
                name = sc.next();
                WaterSource desiredS = test.searchWaterSource(name);
                System.out.println(" Имя: " + desiredS.name);
                break;
            default:
                System.out.println("Введите имя слива");
                name = sc.next();
                Drain desiredD = test.searchDrain(name);
                System.out.println(" Имя: " + desiredD.name);
                break;
        }
    }
}
