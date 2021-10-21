package kr.or.connect.todo.dto;


public class Todo{
	private Long id;
    private String name;
    private String regDate;
    private Integer sequence;
    private String title;
    private String type;

    
    @Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", regDate=" + regDate + ", sequence=" + sequence + ", title="
				+ title + ", type=" + type + "]";
	}

	public Long getId() {
		if (id == null) return (long) 0;
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}

	public String getName() {
		if (name == null) return "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		if (regDate == null) return "";
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getSequence() {
		if (sequence == null) return 0;
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getTitle() {
		if (title == null) return "";
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		if (type == null) return "";
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Todo() {
        // TODO Auto-generated constructor stub
    }
    

	public Todo(Long id, String name, String regDate, Integer sequence, String title, String type) {
		super();
		this.id = id;
		this.name = name;
		this.regDate = regDate;
		this.sequence = sequence;
		this.title = title;
		this.type = type;
	}

}