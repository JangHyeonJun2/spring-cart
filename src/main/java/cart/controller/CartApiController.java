package cart.controller;

import cart.auth.AuthMember;
import cart.controller.response.CartResponse;
import cart.controller.response.MemberResponse;
import cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartApiController {

    private final CartService cartService;

    public CartApiController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart/{productId}")
    public ResponseEntity<Void> addCart(@AuthMember MemberResponse memberResponse, @PathVariable Long productId) {
        cartService.save(memberResponse.getId(), productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cart")
    public ResponseEntity<List<CartResponse>> addCart(@AuthMember MemberResponse memberResponse) {
        return ResponseEntity.ok().body(cartService.findAll(memberResponse.getId()));
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Void> deleteCart(@AuthMember MemberResponse memberResponse, @PathVariable Long id) {
        cartService.deleteById(memberResponse.getId(), id);
        return ResponseEntity.ok().build();
    }
}
