package com.soft_delete.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.springframework.boot.SpringApplicationRunListener;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE books SET deleted = true WHERE id_books=?")
//@SQLRestriction("deleted = false")
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")
public class Books {

    /**
     * untuk melakukan soft delete kita perlu menambahkan 1 field lagi yang di beri tipi Boolean lalu kita set nilai detele awalnya false
     * lalu ketika terjadi proses delete dari frontend status akan berubah menjadi true
     * @SQLDelete() digunakan untuk menuliskan perintah sql dimana ketika tejadi method Delete maka sql akan mengeksekusi perintah update untuk field yang baru dibuat tadi
     * @SQLRestriction("deteled = false") ini annotation untuk menampilkan selama field deleted = false maka akan tampil jika sudah berubah menjadi true(di delete datanya) maka tidak akan ditampilkan
     * dengan begini kita tidak perlu menghapus data yang sebenernya dalam database
     *
     *
     * Terkadang kita ingin melihat data deletednya true maka untuk membuat itu kita tidak perlu lagi menggunakan @SQLRestriction("deleted = false")
     * @FilterDef untuk membuat filter definisi dengan parameter name, parameters, type
     * @Filter untuk membuat filter contoh disini adalah filter dengan condisi field deleted diberi nilai isDeleted yang didapat dari input user di controller nanti
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_books")
    private String id;


    private Integer price;

    @Column(name = "books_name")
    private String bookName;

    private Boolean deleted = Boolean.FALSE; //flegging proses

    // kelemahan menggunakan flegging adalah ketika kita sudah men set data itu true maka tidak pernah di baca lagi dari frontendnya

    // untuk mengatasi masalah ini menggunakan @FilterDef dan @Filter

}
