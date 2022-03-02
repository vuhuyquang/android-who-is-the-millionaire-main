package com.ailatrieuphu.object;


import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class FaceData {
    private ArrayList<Answer> basic_question = new ArrayList<>() ;
    private ArrayList<Answer> medium_question = new ArrayList<>() ;
    private ArrayList<Answer> difficult_question = new ArrayList<>() ;
    private ArrayList<Answer> max_question = new ArrayList<>() ;
    private ArrayList<Answer> arrData = new ArrayList<>() ;

    public FaceData() {
        createQusetion();
        addLevelQuetsion();
    }

    public Answer setQuestion(int capDo, int getIdQuestion) {
        Random r = new Random();
        if (capDo <=5){
            for(int i =0 ; i < basic_question.size(); i ++){
                if(basic_question.get(i).getIdQuestion() == getIdQuestion){
                    basic_question.remove(i);
                }
            }
            Log.d("TAG", "setQuestion: " + getIdQuestion);
            return basic_question.get(r.nextInt(basic_question.size()));
        }else if (capDo <=8){
            for(int i =0 ; i < medium_question.size(); i ++){
                if(medium_question.get(i).getIdQuestion() == getIdQuestion){
                    medium_question.remove(i);
                }
            }
            return medium_question.get(r.nextInt(medium_question.size()));
        }else if (capDo <=12){
            for(int i =0 ; i < difficult_question.size(); i ++){
                if(difficult_question.get(i).getIdQuestion() == getIdQuestion){
                    difficult_question.remove(i);
                }
            }
            return difficult_question.get(r.nextInt(difficult_question.size()));
        }else {
            for(int i =0 ; i < max_question.size(); i ++){
                if(max_question.get(i).getIdQuestion() == getIdQuestion){
                    max_question.remove(i);
                }
            }
            return max_question.get(r.nextInt(max_question.size()));
        }
    }


    public void addLevelQuetsion (){
        for(Answer x : arrData){
            switch (x.getLevelQs()){
                case 1:
                    basic_question.add(x);
                    break;
                case 2:
                    medium_question.add(x);
                    break;
                case 3:
                    difficult_question.add(x);
                    break;
                case 4:
                    max_question.add(x);
                    break;
            }
        }
    }
    public void createQusetion() {
        //1
        arrData.add(fetchAnswer(0,"Điền từ còn thiếu vào chỗ trống trong câu: ”Đục nước béo …”?", "Cò", "Vạc&Cá&Mèo",1));
        arrData.add(fetchAnswer(1,"Việt Nam có chung biên giới với quốc gia nào dưới đây?", "Trung Quốc", "Thái Lan&Myanmar&Bruney",1));
        arrData.add(fetchAnswer(2,"Đâu là tên một ngôi chùa nổi tiếng ở Hà Nam?", "Tam Chúc", "Bãi Đính&Bổ Đà&Trấn Quốc",1));
        arrData.add(fetchAnswer(3,"Sóng biển thường được tạo ra do cái gì?", "Gió", "Nắng&Mưa&Sương mù",1));
        arrData.add(fetchAnswer(4,"Âm thanh có tần số lớn hơn 20KHz gọi là gì?", "Siêu âm", "Hạ âm&Cận âm&Quá âm",1));
        arrData.add(fetchAnswer(5,"Đâu là tên một loại mũ?", "Lưỡi trai", "Lưỡi lê&Lưỡi rắn&Lưỡi hái",1));
        arrData.add(fetchAnswer(6,"Bảy chú lùn trong truyện cổ tích \"Nàng bạch tuyết và bảy chú lùn\" làm nghề gì?", "Thợ mỏ", "Thợ săn&Thợ may&Thợ rèn",1));
        arrData.add(fetchAnswer(7,"\"Bu\" còn có nghĩa khác là ?", "Mẹ", "Một loại khóa&Một điệu hát&Một loại gia vị",1));
        arrData.add(fetchAnswer(8,"Tạp chí Forbes nổi tiếng của Mỹ chuyên viết về lĩnh vực gì?", "Kinh doanh", "Nghệ thuật&Xây dựng&Môi trường",1));
        arrData.add(fetchAnswer(9,"Vận động viên môn bắn súng còn được gọi là gì?", "Xạ thủ", "Cơ thủ&Cung thủ&Cầu thủ",1));
        arrData.add(fetchAnswer(10,"Đâu không phải là một vật dụng?", "Dao động", "Dao bầu&Dao cạo&Dao phay",1));
        arrData.add(fetchAnswer(11,"Đâu là từ còn thiếu trong câu thành ngữ \"Ba hoa ...\"?", "Chích chòe", "Chèo bẻo&Sáo sậu&Họa mi",1));
        //2
        arrData.add(fetchAnswer(12,"Albiceleste là biệt danh của đội tuyển bóng đá quốc gia nào?", "Argentina", "Séc&Bồ Đào Nha&Tây Ban Nha",2));
        arrData.add(fetchAnswer(13,"\"Mona Lisa\" là bức họa nổi tiếng của danh họa nào?", "Leonardo da Vinci", "Pablo Picasso&Andy Warhol&Vincent van Gogh",2));
        arrData.add(fetchAnswer(14,"\"Dẫu mà cha đánh mẹ treo/ Cũng không bỏ hội ... đêm rằm\". Trong dấu ... là ngôi chùa nào?", "Chùa Keo", "Chùa Thiên Mụ&Chùa Hương&Chùa Dâu",2));
        arrData.add(fetchAnswer(15,"Áo khoác ngoài của nhà vua được gọi là gì?", "Hoàng Bào", "Hoàng Long&Hoàng Yến&Hoàng Ân",2));
        arrData.add(fetchAnswer(16,"\"Người đặc biệt\" là biệt danh của HLV bóng đá nào?", "Jose Mourinho", "Sir Alex Ferguson&Pep Guardiola&Carlo Ancelotti",2));
        arrData.add(fetchAnswer(17,"Đâu là loại cháo khác với các món còn lại?", "Cháo heo", "Cháo bò&Cháo vịt&Cháo gà",2));
        arrData.add(fetchAnswer(18,"El Nino là gì?", "Một hiện tượng thời tiết", "Một khu rừng ở châu Phi&Một điệu nhảy&Một loại dương xỉ",2));
        arrData.add(fetchAnswer(19,"Theo một câu hát thì: \"Ba thương con vì con giống mẹ. Mẹ thương con vì con giống ...\" ai?", "Ba", "Chú cạnh nhà&Bác đầu ngõ&Ông hàng xóm",2));
        arrData.add(fetchAnswer(20,"Người ta thường nấu canh cua với thứ gì?", "Rau đay", "Mộc nhĩ&Củ cải&Xúp lơ xanh",2));
        arrData.add(fetchAnswer(21,"Nơi đâu được coi là đất tổ của sân khấu chèo?", "Ninh Bình", "Bắc Ninh&Hà Nam&Phú Thọ",2));
        //3
        arrData.add(fetchAnswer(22,"\"Lộng ngữ\" là cách gọi khác của biện pháp tu từ nào sau đây?", "Chơi chữ", "Ẩn dụ&Hoán dụ&Nhân hóa",3));
        arrData.add(fetchAnswer(23,"Trước khi trở thành HLV của đội tuyển Đức, Joachim Loew đã từng là cần thủ chơi ở vị trí nào thường xuyên?", "Tiền vệ", "Tiền đạo&Hậu vệ&Thủ môn",3));
        arrData.add(fetchAnswer(24,"\"Năm gian nhà cỏ thấp le te/ Ngõ tối đêm sâu đốm lập lòe\" là 2 câu thơ mở đầu của bài thơ nào sau đây?", "Thu ẩm", "Thu vịnh&Thu hứng&Thu điếu",3));
        arrData.add(fetchAnswer(25,"Ai là người đại diện chính thức cho Nước Việt Nam Dân Chủ Cộng Hòa kí hiệp định Paris ngày 27/01/1973?", "Nguyễn Duy Trinh", "Nguyễn Thị Bình&Lê Đức Thọ&Xuân Thủy",3));
        arrData.add(fetchAnswer(26,"B3 là mật danh của chiến trường nào trong cuộc kháng chiến chống Mỹ cứu nước?", "Tây Nguyên", "Trị Thiên&Đường 9 - Bắc Quảng Trị&Đông Nam Bộ",3));
        arrData.add(fetchAnswer(27,"Bài thơ nào sau đây không nằm trong tập \"Nhật ký trong tù\" của Chủ Tịch Hồ Chí Minh?", "Báo tiệp", "Tảo Giải&Vọng nguyệt&Tẩu lộ",3));
        arrData.add(fetchAnswer(28,"Ban nhạc nổi tiếng nào có bài hát được phát lần đầu tiên lên vũ trụ?", "The Beatles", "ABBA&Backstreet Boys&Moden Talking",3));
        arrData.add(fetchAnswer(29,"Bài thơ nào không phải của nhà thơ Nguyễn Bính?", "Tình quê", "Thơ quê&Cho tôi ly nữa&Chân quê",3));
        arrData.add(fetchAnswer(30,"Bánh trôi, bánh chay được làm từ bột gì?", "Bột nếp", "Bột đao&Bột sắn&Bột mì",3));
        arrData.add(fetchAnswer(31,"\"Đường lên Tây Bắc\" là ca khúc do nhạc sĩ nào sáng tác?", "Văn An", "Vũ Trọng Hồi&Hoàng Hiệp&Huy Du",3));
        //4
        arrData.add(fetchAnswer(32,"Đơn vị khoa học nào được đặt theo tên của một nhà quý tộc người Italy?", "Volt", "Pascal&Hertz&Ohm",4));
        arrData.add(fetchAnswer(33,"Trong Word 2010, chức năng Page Layout\\Size có tác dụng gì?", "Chọn cỡ trang giấy(Khổ giấy)", "Thay đổi kích thước văn bản&Chọn hướng của trang giấy&Thiết lập lề văn bản",4));
        arrData.add(fetchAnswer(34,"Trong Chiến tranh thế giới thứ hai, lính Mỹ sử dụng những bình Aerosol đầu tiên để chứa thứ gì?", "Thuốc trừ sâu", "Chất khử trùng&Kem cạo râu&Dung dịch làm sạch",4));
        arrData.add(fetchAnswer(35,"Người nào sau đây không có nguyên tố hóa học được đặt theo tên mình?", "Isaac Newton", "Albert Einstein&Niels Bohr&Enrico Fermi",4));
        arrData.add(fetchAnswer(36,"Ngoài sự nghiệp của nhà chiêm tinh và tiên tri, Nostradamus xuất bản chuyên luận năm 1555 bao gồm một phần về nội dung gì dưới đây?", "Làm mứt và thạch", "Huấn luyện vẹt nói chuyện&Gian lận khi chơi bài&Đào mộ",4));
//        arrData.add(fetchAnswer(37,"Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên4.3", "Sinh nở&Sinh sôi&Sinh đẻ",4));
//        arrData.add(fetchAnswer(38,"Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên4.3", "Sinh nở&Sinh sôi&Sinh đẻ",4));
//        arrData.add(fetchAnswer(39,"Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên4.3", "Sinh nở&Sinh sôi&Sinh đẻ",4));
//        arrData.add(fetchAnswer(40,"Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên4.3", "Sinh nở&Sinh sôi&Sinh đẻ",4));
//        arrData.add(fetchAnswer(41,"Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên4.3", "Sinh nở&Sinh sôi&Sinh đẻ",4));

    }

    // param1: name question
    // param2: answer
    // param3: answer fail
    private Answer fetchAnswer(int id, String s1, String s2, String s3, int level) {
        Answer c1 = new Answer();
        c1.setNoiDung(s1);
        c1.setDapAnDung(s2);
        c1.setIdQuestion(id);
        c1.setArrDapAnSai(s3);
        c1.setLevelQs(level);
        return c1;
    }
}
