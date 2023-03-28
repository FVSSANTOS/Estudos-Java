package entities;

public class Student{
    
    private String name;
    private String cod;
    private String course;

    public Student(String name, String cod, String course){
        this.cod = cod;
        this.name = name;
        this.course = course;
    }

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Gera um número inteiro referente ao atributo que usar para gerar o código
    @Override
    public int hashCode() {
        return getName().length() * 8 + getCod().length() * 8;
    }

    //Retonar um booleano referente a comparação de um atributo ou mais dos objetos 
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Student)){
            return false;
        }else{
            Student s = (Student) obj;
            return this.getName() == s.getName() && this.getCod() == s.getCod();
        }
    }
}