package fpoly.datn.ecommerce_website.service.serviceImpl;

import fpoly.datn.ecommerce_website.dto.CustomerDTO;
import fpoly.datn.ecommerce_website.entity.Customers;
import fpoly.datn.ecommerce_website.repository.ICustomerRepository;
import fpoly.datn.ecommerce_website.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Customers> findAllCustomersWithUserInfoUserRole(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerRepository.findAllCustomersWithUsersRoles(pageable);
    }


    @Override
    public List<Customers> findAll() {
        return this.customerRepository.findAll();
    }


    @Override
    public Customers findById(String id) {
        return this.customerRepository.findById(id).get();
    }


    @Override
    public Customers save(Customers customer) {
        return this.customerRepository.save(customer);
    }


    @Override
    public Customers update(Customers customer) {
        return this.customerRepository.save(customer);
    }


    @Override
    public Customers updateStatus(String id, Integer status) {
        Customers customer = customerRepository.findById(id).get();
        customer.setCustomerStatus(status);
        return this.customerRepository.save(customer);
    }


    @Override
    public String delete(String id) {

        this.customerRepository.deleteById(id);
        return "Delete successfully";
    }


    @Override
    public List<CustomerDTO> findByKeyword(String keyword) {
        List<Customers> customers = this.customerRepository.findByKeyword(keyword);
        return customers.stream()
                .map(c -> modelMapper.map(c, CustomerDTO.class))
                .toList();
    }

}
