package com.example.neloproyect.fragmenttransaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.neloproyect.databinding.FragmentTransactionsBinding

class fragment_transactions : Fragment() {

    lateinit var  transactionViewModel : TransactionViewModel

    private lateinit var binding: FragmentTransactionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentTransactionsBinding.inflate(inflater,container,false)
      return binding.root.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transactionViewModel = ViewModelProvider(this, TransactionViewModel.FACTORY(TransactionsRespository()))
            .get(TransactionViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = transactionViewModel

        transactionViewModel.listTransactions()


    }


}