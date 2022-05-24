/*import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.IUserRepository;
import com.apiCrypto.apiCrypto.service.UserService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


public class UserServiceTest {
    @RunWith(SpringRunner.class)
  @SpringBootTest
    @InjectMocks
	private UserService service;
	
	@Mock
	private IUserRepository repository;
	
	private User client1 = new User("Carlos", "Sanchez", 32345657);
	
	private User client2 = new User(2, 43566879, "Raul", "Fernandez");
		
	@Test
	public void SELECT_CLIENTS() {
		when(repository.findAll()).thenReturn(new ArrayList<Clients>());
		List<Clients> clients = service.getAll();
		assertNotNull(clients);
	}
	
	@Test
	public void SAVE_CLIENT() {
		when(repository.existsByDni(client1.getDni())).thenReturn(false);
		when(repository.save(client1)).thenReturn(null);
		boolean result = service.save(client1);
		assertTrue(result);
	}
	
	@Test
	public void SAVE_CLIENT_FAIL() {
		when(repository.existsByDni(client1.getDni())).thenReturn(true);
		when(repository.save(client1)).thenReturn(null);
		boolean result = service.save(client1);
		assertFalse(result);
	}
	
	@Test
	public void UPDATE_CLIENT() {
		when(repository.existsById(client2.getId())).thenReturn(true);
		when(repository.save(client2)).thenReturn(null);
		boolean result = service.update(client2);
		assertTrue(result);
	}
	
	@Test
	public void UPDATE_CLIENT_FAIL() {
		when(repository.existsById(client2.getId())).thenReturn(false);
		when(repository.save(client2)).thenReturn(null);
		boolean result = service.update(client2);
		assertFalse(result);
	}
	
	@Test
	public void DELETE_CLIENT() {
		when(repository.existsById(client2.getId())).thenReturn(true);
		boolean result = service.delete(client2.getId());
		assertTrue(result);
	}
	
	@Test
	public void DELETE_CLIENT_FAIL() {
		when(repository.existsById(client2.getId())).thenReturn(false);
		boolean result = service.delete(client2.getId());
		assertFalse(result);

}
	}*/