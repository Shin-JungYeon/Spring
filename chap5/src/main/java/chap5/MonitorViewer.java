package chap5;

public class MonitorViewer implements Viewer {
	private DisplayMode displayMode;
	
	public void add(Camera camera) {
		System.out.println("모니터에 " + camera + "영상 추가");
	}

	public void draw() {
		System.out.println(displayMode.getType() + "모드로 카메라 이미지 출력 됨.");
	}

	public void setDisplayMode(DisplayMode displayMode) {  // @Autowired 태그가 없으므로 setter를 통해 객체 생성이 필요함.
		this.displayMode = displayMode;
	}

}
