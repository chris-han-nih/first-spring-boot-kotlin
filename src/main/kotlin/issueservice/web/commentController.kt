package issueservice.web

import issueservice.config.AuthUser
import issueservice.model.CommentRequest
import issueservice.service.CommentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/comments")
class commentController(
  private val commentService: CommentService,
) {
  @PostMapping
  fun createComment(
    authUser: AuthUser,
    @RequestBody comment: CommentRequest,
  ) = commentService.createComment(authUser.userId, comment)
}
