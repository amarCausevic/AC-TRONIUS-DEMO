package model;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyDTO {

  private HashMap<String, ?> pathParams;
  private HashMap<String, String> headers;
  private Object bodyDTO;
}
