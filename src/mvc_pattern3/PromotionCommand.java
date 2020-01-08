package mvc_pattern3;

public class PromotionCommand implements Command {
   PromotionDialog view;
   FileManager fm;
   public PromotionCommand(PromotionDialog view) {
      this.view = view;
      fm = new FileManager();
   }
   
   @Override
   public void excute() {
      // TODO 자동 생성된 메소드 스텁
      String msg = view.promotion;
      fm.savePromotionFile(msg);
      
   }
   
}