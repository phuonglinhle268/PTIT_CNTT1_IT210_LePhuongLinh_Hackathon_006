package org.example.java_web_hackathon;

import java.io.*;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}






//public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    protected Class<?> @Nullable [] getRootConfigClasses() {
//        return new Class[0];
//    }
//
//    @Override
//    protected Class<?> @Nullable [] getServletConfigClasses() {
//        return new Class[]{AppConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setMultipartConfig(
//                new MultipartConfigElement(
//                        "",
//                        25 * 1024 * 1024L, // 25MB max file size
//                        50 * 1024 * 1024L, // 50MB max request size
//                        0
//                )
//        );
//    }
//}

//@Controller
//@RequestMapping("/gadgets")
//public class GadgetController {
//    @Autowired
//    private GadgetService service;
//    String uploadDir = "D:\\Java_Web_Hackathon_Demo\\src\\main\\webapp\\images";
//    @GetMapping
//    public String list(Model model,
//                       @RequestParam(name = "keyword", required = false) String keyword
//    ){
//        if (keyword != null){
//            model.addAttribute("gadgets", service.search(keyword));
//        } else {
//            model.addAttribute("gadgets", service.getAll());
//        }
//        return "list";
//    }
//    @GetMapping("/create")
//    public String showForm(Model model){
//        model.addAttribute("gadgetDTO", new GadgetDTO());
//        model.addAttribute("actionUrl", "/gadgets/create");
//        return "form";
//    }
//    @PostMapping("/create")
//    public String create(
//            @Valid @ModelAttribute("gadgetDTO") GadgetDTO dto,
//            BindingResult result
//    ) throws Exception{
//        if (result.hasErrors()){
//            return "form";
//        }
//        Gadget g = new Gadget();
//        g.setId((long) (service.getAll().size() + 1));
//        g.setProductName(dto.getProductName());
//        g.setBrand(dto.getBrand());
//        g.setStockQuantity(dto.getStockQuantity());
//        //upload file
//        MultipartFile file = dto.getImage();
//        if (file != null && !file.isEmpty()){
//            String fileName = file.getOriginalFilename();
//            File dest = new File(uploadDir + File.separator + fileName);
//            file.transferTo(dest);
//            g.setProductImage(fileName);
//        }
//        service.save(g);
//        return "redirect:/gadgets";
//    }

//    @GetMapping("/edit/{id}")
//    public String edit(
//            @PathVariable("id") Long id,
//            Model model
//    ){
//        Gadget g = service.findById(id);
//        GadgetDTO dto = new GadgetDTO();
//        dto.setProductName(g.getProductName());
//        dto.setBrand(g.getBrand());
//        dto.setStockQuantity(g.getStockQuantity());
//        model.addAttribute("gadgetDTO", dto);
//        model.addAttribute("id", id);
//        model.addAttribute("actionUrl", "/gadgets/edit/" + id);
//        model.addAttribute("currentImage", g.getProductImage());
//        return "form";
//    }
//    @PostMapping("/edit/{id}")
//    public  String update(
//            @PathVariable("id") Long id,
//            @Valid @ModelAttribute GadgetDTO dto,
//            BindingResult result
//    ){
//        if (result.hasErrors()){
//            return "form";
//        }
//        Gadget g = new Gadget();
//        g.setId(id);
//        g.setProductName(dto.getProductName());
//        g.setBrand(dto.getBrand());
//        g.setStockQuantity(dto.getStockQuantity());
//
//        // ← Thêm phần xử lý ảnh
//        MultipartFile file = dto.getImage();
//        if (file != null && !file.isEmpty()){
//            // Có chọn ảnh mới → upload ảnh mới
//            try {
//                String fileName = file.getOriginalFilename();
//                File dest = new File(uploadDir + File.separator + fileName);
//                file.transferTo(dest);
//                g.setProductImage(fileName);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            // Không chọn ảnh mới → giữ ảnh cũ
//            Gadget old = service.findById(id);
//            g.setProductImage(old.getProductImage());
//        }
//        service.update(g);
//        return "redirect:/gadgets";
//    }
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        service.delete(id);
//        return "redirect:/gadgets";
//    }
//}


//public class GadgetDTO {
////    @NotBlank(message = "Mã sinh viên không được để trống")
////    @Pattern(regexp = "^[A-Za-z]{2}\\d+$",
////            message = "Mã SV phải bắt đầu bằng 2 chữ cái, theo sau là các chữ số (VD: HN001)")
////@NotNull(message = "Ngày nhận không được để trống")
////@Future(message = "Ngày nhận phải sau ngày hôm nay")
////@DateTimeFormat(pattern = "yyyy-MM-dd")
//    //@Email
//
//    @NotBlank(message = "Tên sản phẩm không được để trống")
//    @Size(min = 3, max = 100, message = "Từ 3-100 kí tự")
//    private String productName;
//
//    @NotBlank(message = "Tên hãng không để trống")
//    private String brand;
//
//    @NotNull(message = "Không để trống")
//    @Min(value = 0, message = ">= 0")
//    private Integer stockQuantity;
//
//    private MultipartFile image;  /constructor, getset


//public class Gadget {
//    private Long id;
//    private String productName;
//    private String brand;
//    private Integer stockQuantity;
//    private String productImage;


//@Repository
//public class GadgetRepository {
//    List<Gadget> list = new ArrayList<>();
//
//    public List<Gadget> findAll(){return list;}
//
//    public void save(Gadget g){list.add(g);}
//
//    public void update(Gadget g){
//        delete(g.getId());
//        list.add(g);
//    }
//    public Gadget findById(Long id){
//        return list.stream()
//                .filter(x -> x.getId().equals(id))
//                .findFirst().orElse(null);
//    }
//    public void delete(Long id){list.removeIf(x -> x.getId().equals(id));}
//}


//@Service
//public class GadgetService {
//    @Autowired
//    private GadgetRepository repo;
//
//    public List<Gadget> getAll(){
//        return repo.findAll();
//    }
//
//    public void save(Gadget g){
//        repo.save(g);
//    }
//
//    public void update(Gadget g){
//        repo.update(g);
//    }
//
//    public Gadget findById(Long id){
//        return repo.findById(id);
//    }
//    public void delete(Long id){
//        repo.delete(id);
//    }
//    public List<Gadget> search(String keyword){
//        return repo.findAll().stream()
//                .filter(g -> g.getProductName().toLowerCase().contains(keyword.toLowerCase())
//                        || g.getBrand().toLowerCase().contains(keyword.toLowerCase()))
//                .toList();
//    }
//}


//list
//<h2>Danh sách Gadget</h2>
//<form method="get">
//    <input name="keyword"/>
//    <button>Tìm</button>
//</form>
//<a href="/gadgets/create">Thêm mới</a>
//<table border="1">
//    <tr>
//        <th>ID</th>
//        <th>Tên</th>
//        <th>Hãng</th>
//<th>Số lượng</th>
//        <th>Ảnh</th>
//        <th>Action</th>
//    </tr>
//
//    <tr th:each="g : ${gadgets}">
//        <td th:text="${g.id}"></td>
//        <td th:text="${g.productName}"></td>
//        <td th:text="${g.brand}"></td>
//        <td th:text="${g.stockQuantity}"></td>
//        <td>
//            <img th:if="${g.productImage}"
//th:src="@{'/images/' + ${g.productImage}}" width="50"/>
//        </td>
//        <td>
//            <a th:href="@{'/gadgets/' + ${g.id}}">Chi tiết</a>
//            <a th:href="@{'/gadgets/edit/' + ${g.id}}">Sửa</a>
//            <a th:href="@{'/gadgets/delete/' + ${g.id}}"
//onclick="return confirm('Xóa?')">Xóa</a>
//        </td>
//    </tr>
//</table>
//<p style="color: #ff354d" th:if="${#lists.isEmpty(gadgets)}">Kho trống</p>


//form
//<form method="post" enctype="multipart/form-data"
//th:action="${actionUrl}"
//th:object="${gadgetDTO}">
//    <div class="form-group">
//<label>Tên sản phẩm</label>
//        <input type="text" th:field="*{productName}"
//class="form-control" name="" id="" placeholder="">
//        <p class="error" th:errors="*{productName}"></p>
//    </div>
//    <div class="form-group">
//        <label>Hãng</label>
//        <input type="text" th:field="*{brand}"
//class="form-control" name="" id="" placeholder="">
//        <p class="error" th:errors="*{brand}"></p>
//    </div>
//    <div class="form-group">
//<label>Số lượng</label>
//        <input type="number" th:field="*{stockQuantity}"
//class="form-control" name="" id="" placeholder="">
//        <p class="error" th:errors="*{stockQuantity}"></p>
//    </div>
//    <div class="form-group">
//        <label>Ảnh</label>
//        <div th:if="${currentImage}">
//            <img th:src="@{'/images/' + ${currentImage}}" width="100"/>
//        </div>
//        <input type="file" th:field="*{image}"
//class="form-control" name="" id="">
//        <p class="error" th:errors="*{productName}"></p>
//    </div>
//    <div>
//        <button type="submit" class="btn btn-primary">Lưu</button>
//    </div>
//</form>


