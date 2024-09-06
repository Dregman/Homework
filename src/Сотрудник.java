public class Сотрудник {
    private String ФИО;
    private String должность;
    private String email;
    private String телефон;
    private int зарплата;
    private int возраст;


    public Сотрудник (String ФИО, String должность, String email, String телефон, int зарплата, int возраст) {
        this.ФИО = ФИО;
        this.должность = должность;
        this.email = email;
        this.телефон = телефон;
        this.зарплата = зарплата;
        this.возраст = возраст;
    }

    public void outputInform() {
        System.out.println("ФИО: " + ФИО);
        System.out.println("Доллжность: " + должность);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + телефон);
        System.out.println("Зарплата: " + зарплата);
        System.out.println("Возраст: " + возраст);

    }
    public static void main(String[] args) {
        Сотрудник[] persArray = new Сотрудник[5];
        persArray [0] = new Сотрудник("Коваленко Игорь Михайлович", "Менеджер", "igor.koval@gmail.com",
 "375296784455", 1450, 31);
        persArray [1] = new Сотрудник("Захаренко Яков Валентинович", "Инженер-эколог", "Zacharenko.yakov@gmail.com",
                "375292348521", 1200, 29);
        persArray [2] = new Сотрудник("Мазай Кристина Николаевна", "Консультант", "kristina13@gmail.com",
                "375298759047", 1350, 24);
        persArray [3] = new Сотрудник("Пусловский Валерий Сергеевич", "Инженер-химик", "val.puslovki@gmail.com",
                "375299781093", 1850, 35);
        persArray [4] = new Сотрудник("Лосев Олег Денисович", "Начальник отдела ООС", "oleglosev@gmail.com",
                "375295610909", 2300, 34);

        //Можно вывести информацию о любом сотруднике
        persArray[1].outputInform();

    }



}
