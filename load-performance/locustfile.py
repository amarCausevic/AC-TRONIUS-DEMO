from locust import HttpUser, task, between


class LocustBlaze(HttpUser):
  wait_time = between(1, 5)

  @task
  def user_behaviour(self):
    self.client.get("/")
    self.client.post("/reserve.php")
    self.client.post("/purchase.php")
    self.client.post("/confirmation.php")
    self.client.post("/confirmations.php")
