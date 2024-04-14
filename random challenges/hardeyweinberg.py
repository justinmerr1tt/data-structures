import random
z=0
gen1_p = 0.37
gen1_q = 1 - gen1_p

#pop size
n = 20
num_trials = 100000

for p in range(num_trials):
    pp_obs = 0
    qp_pq_obs = 0
    qq_obs = 0

    gen2_num_p = 0
    gen2_num_q = 0
    for x in range(n):
        if random.random() < gen1_p:
            allele_1 = "p"
            gen2_num_p += 1
        else:
            allele_1 = "q"
            gen2_num_q += 1

        if random.random() < gen1_p:
            allele_2 = "p"
            gen2_num_p += 1
        else:
            allele_2 = "q"
            gen2_num_q += 1

        cur_geno = allele_1 + allele_2
        # print(cur_geno)
        if cur_geno == "pp":
            pp_obs += 1
        elif cur_geno == "qq":
            qq_obs += 1
        elif cur_geno in ["pq", "qp"]:
            qp_pq_obs += 1


    # n*2 gives num alleles per org
    gen2_p = gen2_num_p / (n*2)
    gen2_q = 1 - gen2_p
    # print(gen2_p)
    # print(gen2_q)

    # chi sqaure:

    obs = [pp_obs, qp_pq_obs, qq_obs]
    # print(pp_obs + pq_qp_obs + qq_obs)


    pp_exp = gen2_p * gen2_p * n
    pq_qp_exp = 2 * gen2_p * gen2_q * n
    qq_exp = gen2_q * gen2_q * n
    exp = [pp_exp, pq_qp_exp, qq_exp]
    # print(pp_exp + pq_qp_exp + qq_exp)

    chi_square = 0


    for x in range(3):
        chi_square += (((obs[x] - exp[x]) ** 2) / exp[x])
        #print(chi_square)

    # print(chi_square)
    
    if chi_square > 3.84:
        #print("REJECT")
        z += 1

#print("number rejected: " + str(num_trials - z))
print(z)
