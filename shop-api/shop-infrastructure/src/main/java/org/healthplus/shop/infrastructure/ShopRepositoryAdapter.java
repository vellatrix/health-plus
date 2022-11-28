package org.healthplus.shop.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.repository.ShopRepository;
import org.healthplus.shop.domain.shop.Menu;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ShopRepositoryAdapter implements ShopRepository {

  private final JpaShopRepository jpaShopRepository;
  private final EntityManager em;

  @Override
  public Shop saveShop(Shop shop) {
    return jpaShopRepository.save(shop);
  }

  @Override
  public Optional<Shop> findById(Long id) {
    return jpaShopRepository.findById(id);
  }

  @Override
  public List<Menu> findByShopId(Long shopId) {
    /*return em.createQuery("select m, og, o from Menu m " +
            "join m.optionGroups og " +
            "join og.options o where m.id = :shopId", Menu.class)
             .setParameter("shopId", shopId)
            .getResultList();*/
    return null;
  }

  @Override
  public void removeShop(Shop shop) {
    jpaShopRepository.delete(shop);
  }


  @Override
  public void saveMenu(Menu menu) {
    em.persist(menu);
  }

  @Override
  public void saveMenus(List<Menu> menus) {
    menus.forEach(menu -> em.persist(menu));
  }
}
