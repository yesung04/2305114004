import java.util.ArrayList;
import java.util.Scanner;

public class Sample {

    static class Student {  
        static int nextid = 260101;

        private String name;
        private int id;
        private String gender;
        private Double[] grade;
        private int age;
        private String contact;

        public Student(String input_name){
            this.name = input_name;
            this.id = nextid++;
            this.gender = "미입력";
            this.grade = new Double[4];
            this.age = 0;   
            this.contact = "미입력";
        }

        void setGender(String input_gender){ this.gender = input_gender; }
        void setAge(int input_age){ this.age = input_age; }
        void setContact(String input_contact){ this.contact = input_contact; }

        void setGrade(int input_semester, double input_grade){
            if (input_semester >= 1 && input_semester <= 4) {
                this.grade[input_semester - 1] = input_grade;
            } else {
                System.out.println("잘못된 학기 입력입니다.");
            }
        }

        public int getId(){ return id; }
        public String getName(){ return name; }

        public void showinfo(){
            System.out.println("------------------");
            System.out.println("학번: " + this.id);
            System.out.println("이름: " + this.name);
            System.out.println("성별: " + this.gender);
            System.out.println("연락처: " + this.contact);
            System.out.println("나이: " + this.age);
            System.out.println("학기별 성적: ");

            for (int i = 0; i < 4; i++){
                Double g = this.grade[i];
                if (g == null) {
                    System.out.print((i + 1) + "학기 [미입력] ");
                } else {
                    System.out.print((i + 1) + "학기 [" + g + "] ");
                }
            }
            System.out.println();
        }
    }

    static Integer parseInt(String input){
        try { return Integer.parseInt(input); }
        catch(Exception e){ System.out.println("숫자 입력 오류"); return null; }
    }

    static Double parseDouble(String input){
        try { return Double.parseDouble(input); }
        catch(Exception e){ System.out.println("숫자 입력 오류"); return null; }
    }

    static Student findStudent(ArrayList<Student> list, int id){
        for(Student s : list){
            if(s.getId() == id) return s;
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while(true)
        {
            System.out.println("=== 폴리텍 학적 관리 시스템 ===");
            System.out.println("1. 학생등록 | 2. 성적/정보 수정 | 3. 전체 명단 출력 | 4. 종료");
            System.out.print("메뉴 선택 : ");

            String menu = sc.nextLine();

            switch(menu){

                case "1":
                    System.out.print("이름 입력 : ");
                    String name = sc.nextLine();

                    Student s = new Student(name);

                    System.out.print("성별 입력 : ");
                    s.setGender(sc.nextLine());

                    System.out.print("나이 입력 : ");
                    Integer age = parseInt(sc.nextLine());
                    if(age != null) s.setAge(age);

                    System.out.print("연락처 입력: ");
                    s.setContact(sc.nextLine());

                    for(int i = 1; i <= 4; i++){
                        System.out.print(i + "학점 입력 (엔터 시 건너뜀): ");
                        String input = sc.nextLine();

                        if(!input.isEmpty()){
                            Double grade = parseDouble(input);
                            if(grade != null) s.setGrade(i, grade);
                        }
                    }

                    list.add(s);
                    System.out.println("학생 등록 완료");
                    break;

                case "2":
                    if(list.isEmpty()){
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }

                    for(Student stu : list){
                        System.out.println("학번: " + stu.getId() + " | 이름: " + stu.getName());
                    }

                    System.out.print("수정할 학생의 학번 입력: ");
                    Integer targetId = parseInt(sc.nextLine());
                    if(targetId == null) break;

                    Student target = findStudent(list, targetId);
                    if(target == null){
                        System.out.println("해당 학생 없음");
                        break;
                    }

                    while(true){
                        System.out.println("1. 성별 | 2. 나이 | 3. 연락처 | 4. 성적 | 5. 메인메뉴");
                        System.out.print("선택: ");
                        String sub = sc.nextLine();

                        switch(sub){

                            case "1":
                                System.out.println("성별 선택: 1 남자 | 2 여자");
                                String genderChoice = sc.nextLine();

                                switch(genderChoice){
                                    case "1": target.setGender("남자"); break;
                                    case "2": target.setGender("여자"); break;
                                    default: System.out.println("잘못된 입력");
                                }
                                break;

                            case "2":
                                System.out.print("나이 : ");
                                Integer newAge = parseInt(sc.nextLine());
                                if(newAge != null) target.setAge(newAge);
                                break;

                            case "3":
                                System.out.print("연락처 : ");
                                target.setContact(sc.nextLine());
                                break;

                            case "4":
                                System.out.print("학기(1~4) : ");
                                Integer sem = parseInt(sc.nextLine());

                                System.out.print("학점 : ");
                                Double g = parseDouble(sc.nextLine());

                                if(sem != null && g != null){
                                    target.setGrade(sem, g);
                                }
                                break;

                            case "5":
                                break;

                            default:
                                System.out.println("잘못된 입력");
                                continue;
                        }

                        if(sub.equals("5")) break;
                    }
                    break;

                case "3":
                    if(list.isEmpty()){
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        for(Student stu : list){
                            stu.showinfo();
                        }
                    }
                    break;

                case "4":
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}