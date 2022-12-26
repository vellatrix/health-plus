package org.healthplus.shop.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.repository.ShopRepository;
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
  public Shop save(Shop shop) {
    return jpaShopRepository.save(shop);
  }

  @Override
  public Optional<Shop> findById(Long id) {
    return jpaShopRepository.findById(id);
  }

  @Override
  public Optional<Shop> findByVendorId(Long vendorId) {
    return jpaShopRepository.findByVendorId(vendorId);
  }

  @Override
  public void remove(Shop shop) {
    jpaShopRepository.delete(shop);
  }

  @Override
  public List<Shop> findAllByVendorId(Long vendorId) {
    return jpaShopRepository.findAllByVendorId(vendorId);
  }

  @Override
  public List<Shop> findAllByCategoryId(Integer categoryId) {
    return jpaShopRepository.findAllByCategoryId(categoryId);
  }

  public Menu saveMenu(Menu menu) {
    em.persist(menu);
    em.flush();

    return em.createQuery("select m, og, o from Menu m join OptionGroup og on m.id = og.menuId " +
            "join Option o on og.id = o.optionGroupId where m.id = :menuId", Menu.class)
            .setParameter("menuId", menu.getId())
            .getSingleResult();
  }

  @Override
  public Optional<Menu> findMenuByMenuId(Long menuId) {
    return Optional.ofNullable(em.createQuery("select m, og, o from Menu m join OptionGroup og on m.id = og.menuId " +
            "join Option o on og.id = o.optionGroupId where m.id = :menuId", Menu.class)
            .setParameter("menuId", menuId)
            .getSingleResult());
  }

  @Override
  public List<Menu> findMenus(Long shopId, int start, int size) {
    return em.createQuery("select m, og, o from Menu m join OptionGroup og on m.id = og.menuId " +
            "join Option o on og.id = o.optionGroupId where m.shopId = :shopId", Menu.class)
            .setParameter("shopId", shopId)
            .setFirstResult(start)
            .setMaxResults(size)
            .getResultList();
  }

  @Override
  public List<Menu> findAllMenus(Long shopId) {
    return em.createQuery("select m, og, o from Menu m join OptionGroup og on m.id = og.menuId " +
            "join Option o on og.id = o.optionGroupId where m.shopId = :shopId", Menu.class)
            .setParameter("shopId", shopId)
            .getResultList();
  }
}
